package InterfaceAdapters;

import UseCases.ChatUseCases.ChatRepoUseCase;
import UseCases.ReadWriter;

import java.io.*;

public class ChatGateway implements ReadWriter {
    @Override
    public Object readFromFile(String filepath) throws IOException, ClassNotFoundException {
        InputStream file = new FileInputStream(filepath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        //read from file

        ChatRepoUseCase chatRepoUseCase = (ChatRepoUseCase) input.readObject();
        input.close();
        return chatRepoUseCase;
    }

    @Override
    public void saveToFile(String filepath, Object chatRepoUseCase) throws IOException {
        OutputStream file = new FileOutputStream(filepath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Graph
        output.writeObject(chatRepoUseCase);
        output.close();
    }
}