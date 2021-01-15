/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2021, Heinz Kabutz, All rights reserved.
 */

package command.exercise1;

public class LightTurnOnCommand implements Command {
    private final Light light;

    public LightTurnOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}
