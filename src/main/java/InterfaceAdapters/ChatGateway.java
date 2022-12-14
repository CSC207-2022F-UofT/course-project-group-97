package InterfaceAdapters;

import UseCases.chat.ChatRepoUseCase;
import UseCases.ReadWriter;

import java.io.*;

/**
 * ChatGateway is an Interface Adapter class responsible for reading from and
 * writing to the serialized files that correspond to the chat data that is
 * stored.
 *
 * @author Rudy
 * @since 1.0
 */
public class ChatGateway implements ReadWriter {
    /**
     * Retrieves data from a serialized file. In particular,
     * used to retrieve a ChatRepoUseCase object from the database
     * to access the previously existing Chatrooms.
     *
     * @param filepath The filepath to the .ser file storing ChatRepoUseCase.
     * @return  The ChatRepoUseCase object stored in the file at filepath.
     * @throws IOException if some input/output error occurs while reading from the file.
     * @throws ClassNotFoundException if the class the object is being loaded into cannot be found
     */
    @Override
    public ChatRepoUseCase readFromFile(String filepath) throws IOException, ClassNotFoundException {
        InputStream file = new FileInputStream(filepath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        //read from file

        ChatRepoUseCase chatRepoUseCase = (ChatRepoUseCase) input.readObject();
        chatRepoUseCase.readingChats();
        input.close();
        return chatRepoUseCase;
    }

    /**
     * Saves the object chatRepoUseCase into a .ser file specific by
     * filepath.
     *
     * @param filepath The filepath to the .ser file storing the input object.
     * @param chatRepoUseCase ChatRepoUseCase object that needs to be serialized.
     * @throws IOException if some input/output error occurs while writing to the file.
     */
    @Override
    public void saveToFile(String filepath, Object chatRepoUseCase) throws IOException {
        OutputStream file = new FileOutputStream(filepath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);
        ChatRepoUseCase chatRepoUseCase1 = (ChatRepoUseCase) chatRepoUseCase;
        chatRepoUseCase1.savingChats();

        // serialize the Graph
        output.writeObject(chatRepoUseCase);
        output.close();
    }
}
