package com.dbortnichuk.db.ui.console;

import com.dbortnichuk.db.core.*;
import com.dbortnichuk.db.model.Record;

import java.util.Map;
import java.util.Scanner;

/**
 * User: dbortnichuk
 * Date: 2/9/14
 * Time: 1:12 PM
 */
public class CommandProcessor {

    public static final String COMMAND_START = "start";
    public static final String COMMAND_STOP = "stop";
    public static final String COMMAND_RETRIEVE = "retrieve";
    public static final String COMMAND_CREATE = "create";
    public static final String COMMAND_UPDATE = "update";
    public static final String COMMAND_DELETE = "delete";
    public static final String COMMAND_WRITE = "write";
    public static final String COMMAND_READ = "read";
    public static final String COMMAND_EXIT = "exit";
    public static final String COMMAND_CONNECT = "connect";


    public static void process(Engine controlledEngine) {

        Scanner scanner = new Scanner(System.in);

        CoreOperations<String, byte[]> coreOperations = (CoreOperations<String, byte[]>) controlledEngine.
                getOperationGroup(CoreOperations.OPERATION_GROUP_CORE);

        PersistenceOperations persistenceOperations = (PersistenceOperations) controlledEngine.
                getOperationGroup(PersistenceOperations.OPERATION_GROUP_PERSISTENCE);

        while (true) {
            System.out.println("Please enter command:");
            String input = scanner.nextLine();
            String[] splitInput = input.split("\\s+");
            String[] splitInputChecked = null;
            String command = "";
            String name = "";
            String phone = "";

            if (splitInput != null && splitInput.length > 0) {
                if (!splitInput[0].equals("") && !splitInput[0].equals(" ")) {
                    splitInputChecked = splitInput;
                    command = splitInputChecked[0];
                } else if ((splitInput[0].equals("") || splitInput[0].equals(" ")) && splitInput.length > 1) {
                    splitInputChecked = new String[splitInput.length - 1];
                    for (int i = 0; i < splitInput.length - 1; i++) {
                        splitInputChecked[i] = splitInput[i + 1];
                    }
                    command = splitInputChecked[0];
                }
            } else {
                System.out.println("Command cannot be blank");
            }


            if (command.equals(CommandProcessor.COMMAND_RETRIEVE)) {
                if (splitInputChecked.length > 1) {
                    name = splitInputChecked[1];
                    byte[] record = coreOperations.retrieve(name);
                    if (record != null) {
                        RecordConverter converter = new RecordConverter();
                        Record convertedRecord = converter.byteArrayAsObject(record);
                        System.out.println("Name: " + convertedRecord.getName() + ", Phone: " + convertedRecord.getPhone());
                    } else {
                        System.out.println("Record '" + name + "' not found");
                    }

                } else {
                    System.out.println("Not enough arguments to process");
                }
            } else if (command.equals(CommandProcessor.COMMAND_CREATE)) {
                if (splitInputChecked.length > 2) {
                    name = splitInputChecked[1];
                    phone = splitInputChecked[2];
                    Record recordToStore = new Record(name, phone);
                    RecordConverter converter = new RecordConverter();
                    coreOperations.create(name, converter.objectAsByteArray(recordToStore));
                    System.out.println("Successfully created");
                } else {
                    System.out.println("Not enough arguments to process");
                }
            } else if (command.equals(CommandProcessor.COMMAND_UPDATE)) {
                if (splitInputChecked.length > 2) {
                    name = splitInputChecked[1];
                    phone = splitInputChecked[2];
                    byte[] record = coreOperations.retrieve(name);
                    if (record != null) {
                        Record recordToUpdate = new Record(name, phone);
                        RecordConverter converter = new RecordConverter();
                        coreOperations.update(name, converter.objectAsByteArray(recordToUpdate));
                        System.out.println("Successfully updated");
                    } else {
                        System.out.println("Record '" + name + "' not found to update, use 'create' command instead");
                    }


                } else {
                    System.out.println("Not enough arguments to process");
                }
            } else if (command.equals(CommandProcessor.COMMAND_DELETE)) {
                if (splitInputChecked.length > 1) {
                    name = splitInputChecked[1];
                    byte[] record = coreOperations.retrieve(name);
                    if (record != null) {
                        coreOperations.delete(name);
                        System.out.println("Successfully deleted");
                    } else {
                        System.out.println("Record '" + name + "' not found to be deleted");
                    }
                } else {
                    System.out.println("Not enough arguments to process");
                }
            } else if (command.equals(CommandProcessor.COMMAND_READ)) {
                Object persistedStorage = persistenceOperations.read();
                controlledEngine.getMapBasedStorage().setDataContainer((Map)persistedStorage);
            } else if (command.equals(CommandProcessor.COMMAND_WRITE)) {
                persistenceOperations.write();
            } else if (command.equals(CommandProcessor.COMMAND_EXIT)) {
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
            } else if (!command.isEmpty()) {
                System.out.println("Command '" + command + "' not found");
            }
        }
    }
}
