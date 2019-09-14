package io.github.hapjava.accessories;

import io.github.hapjava.HomekitAccessory;
import io.github.hapjava.HomekitCharacteristicChangeCallback;
import io.github.hapjava.Service;
import io.github.hapjava.accessories.properties.CarbonDioxideDetectedState;
import io.github.hapjava.impl.services.CarbonDioxideSensorService;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

/**
 * A carbon dioxide sensor reports whether carbon dioxide has been detected or not.
 *
 * <p>Carbon dioxide sensors that run on batteries will need to implement this interface and also
 * implement {@link BatteryStatusAccessory}.
 *
 * @author Eugen Freiter
 */
public interface CarbonDioxideSensor extends HomekitAccessory {

  /**
   * Retrieves the state of the sensor that indicates if carbon dioxide has been detected.
   *
   * @return a future that will contain the carbon dioxide sensor's state
   */
  CompletableFuture<CarbonDioxideDetectedState> getCarbonDioxideDetectedState();

  @Override
  default Collection<Service> getServices() {
    return Collections.singleton(new CarbonDioxideSensorService(this));
  }

  /**
   * Subscribes to changes in the carbon dioxide's state.
   *
   * @param callback the function to call when the state changes.
   */
  void subscribeCarbonDioxideDetectedState(HomekitCharacteristicChangeCallback callback);

  /**
   * Retrieves the carbon dioxide level
   *
   * @return a future that will contain the carbon dioxide level as a value between 0 and 100000
   */
  CompletableFuture<Double> getCarbonDioxideLevel();

  /** Unsubscribes from changes in the carbon dioxide's state. */
  void unsubscribeCarbonDioxideDetectedState();

  /**
   * Subscribes to changes in the carbon dioxide level.
   *
   * @param callback the function to call when the state changes.
   */
  void subscribeCarbonDioxideLevel(HomekitCharacteristicChangeCallback callback);

  /** Unsubscribes from changes in the carbon dioxide level. */
  void unsubscribeCarbonDioxideLevel();
}
