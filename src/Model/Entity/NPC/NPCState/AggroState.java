package Model.Entity.NPC.NPCState;

import Model.Entity.NPC.NPC;
import Model.Entity.Player;
import Model.Map.Direction;
import Model.Map.Location;

import java.util.*;

public class AggroState implements NPCState {

    private int visibleRange = 5;       //range(# of moves/Locations/steps) within which the NPC can see the player

    @Override
    public void move(NPC npc, Player player) {
        Location start = npc.getLocation();
        Location goal = player.getLocation();
        PriorityQueue<LocationQueueNode> queue = new PriorityQueue<LocationQueueNode>(10, new Comparator<LocationQueueNode>() {
            @Override
            public int compare(LocationQueueNode node1, LocationQueueNode node2) {
                if(node1.cost > node2.cost){
                    return 1;
                }

                else if (node1.cost < node2.cost){
                    return -1;
                }
                return 0;
            }
        });

        LocationQueueNode initialNode = new LocationQueueNode(start, new ArrayList<>(), 0);
        queue.add(initialNode);
        Set<LocationQueueNode> visited = new HashSet<LocationQueueNode>();

        while (!queue.isEmpty()) {
            LocationQueueNode currentNode = queue.poll();
            visited.add(currentNode);

            //if the player has been found in the visible range, get path and move NPC in the right direction.
            if (currentNode.location == goal) {
                ArrayList<Direction> finalPath = queue.peek().path;
                player.move(finalPath.get(0));

            }

            for (Direction direction : Direction.values()) {
                Location nextLocation = currentNode.location.getAdjacentAt(direction);
                if (nextLocation != null && nextLocation.moveAllowed(npc)) {
                    //increment path and cost for new node
                    LocationQueueNode toVisit = new LocationQueueNode(nextLocation, currentNode.path, currentNode.cost + 1);
                    toVisit.path.add(direction);

                    //if unvisited and within range, add to queue
                    if (!queue.contains(toVisit) && !visited.contains(toVisit) && toVisit.cost <= visibleRange) {
                        queue.add(toVisit);
                    }
                    // if in queue and current path cost is cheaper, update path and cost in existing node
                    else if (queue.contains(toVisit)) {
                        Iterator<LocationQueueNode> iter = queue.iterator();
                        LocationQueueNode existing;
                        while (iter.hasNext()) {
                            existing = iter.next();
                            if (existing.equals(toVisit) && existing.cost > currentNode.cost) {
                                queue.remove(existing);
                                toVisit.cost = currentNode.cost + existing.cost;
                                queue.add(toVisit);
                                break;
                            }
                            iter.remove();
                        }

                    }
                }
            }

        }

    }

    public class LocationQueueNode {
        public Location location;
        public ArrayList<Direction> path;
        public int cost;

        public LocationQueueNode(Location location, ArrayList<Direction> path, int cost) {
            this.location = location;
            this.path = path;
            this.cost = cost;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof LocationQueueNode) {
                LocationQueueNode other = (LocationQueueNode) o;
                return other.location == this.location;
            }
            return false;
        }

    }
}


