package Comman_Pattern;

public class CommandPatternTest {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);

        RemoteControl remote = new RemoteControl();

        // Turn on the living room light
        remote.setCommand(livingRoomLightOn);
        remote.pressButton();

        // Turn off the living room light
        remote.setCommand(livingRoomLightOff);
        remote.pressButton();

        // Turn on the kitchen light
        remote.setCommand(kitchenLightOn);
        remote.pressButton();

        // Turn off the kitchen light
        remote.setCommand(kitchenLightOff);
        remote.pressButton();
    }
}
