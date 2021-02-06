package trafficlights;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TrafficLight[] trafficLights = Arrays.stream(scan.nextLine().split(" "))
                .map(e -> TrafficLight.valueOf(e))
                .toArray(TrafficLight[]::new);

        int n = Integer.parseInt(scan.nextLine());

        TrafficLight[] lights = TrafficLight.values();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < trafficLights.length; j++) {
                int index = (trafficLights[j].ordinal() + 1) % lights.length;
                // % arr.length is a standard way to ensure we do not go out
                // of array's borders.
                trafficLights[j] = lights[index];

                sb.append(trafficLights[j].toString()).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}