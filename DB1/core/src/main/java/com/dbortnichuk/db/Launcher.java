package com.dbortnichuk.db;

import com.dbortnichuk.db.core.*;
import com.dbortnichuk.db.exception.CommandException;
import com.dbortnichuk.db.ui.CommandProcessor;

/**
 * User: dbortnichuk
 * Date: 2/9/14
 * Time: 12:11 PM
 */
public class Launcher {

    public static void main(String[] args) throws CommandException {

        Engine engine = null;
        CoreOperations coreOperations = null;
        PersistenceOperations persistenceOperations = null;

        if (args[0].equals(CommandProcessor.COMMAND_START)) {
            System.out.println("Starting database");
            engine = new Engine();
            coreOperations = new CoreOperationsBaseImpl(engine);
            engine.operationCallback(coreOperations);
            persistenceOperations = new PersistenceOperationsBaseImpl(engine);
            engine.operationCallback(persistenceOperations);
        } else if (args[0].equals(CommandProcessor.COMMAND_STOP)) {
            System.out.println("Command not supported");
        } else if (args[0].equals(CommandProcessor.COMMAND_CONNECT)) {
            System.out.println("Command not supported");
        } else {
            System.out.println("Command not supported");
//            //throw new CommandException("Command does not exist");
//            System.out.println("Starting database");
//            engine = new Engine();
//            coreOperations = new CoreOperationsBaseImpl(engine);
//            engine.operationCallback(coreOperations);
//            persistenceOperations = new PersistenceOperationsBaseImpl(engine);
//            engine.operationCallback(persistenceOperations);
        }

        CommandProcessor.process(engine);


    }
}
