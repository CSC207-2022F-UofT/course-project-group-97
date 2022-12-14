package UseCases.dataretrieval;
import Entities.UserGraph;

import java.io.IOException;

/**
 * Retrieves the most up to date userGraph object.
 */
public class CurrentGraph {

    /** Reads the userGraph file and retrieves the most up-to-date graph.
     * @return UserGraph which was read from userGraoh. ser
     */
    public static UserGraph getGraph() {
        UserGraphReadWriter readWriter = new UserGraphReadWriter();
        UserGraph readGraph = null;

        try {
            readGraph = readWriter.readFromFile("userGraph.ser");
        } catch (
                IOException e) {
            System.out.println("User list did not read.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return readGraph;
    }

    public static void main(String[] args) {
        UserGraph user = getGraph();
        System.out.println(user.getUsernames());
    }
}