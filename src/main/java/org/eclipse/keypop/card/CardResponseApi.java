/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 ************************************************************************************** */
package org.eclipse.keypop.card;

import java.io.Serializable;
import java.util.List;
import org.eclipse.keypop.card.spi.CardRequestSpi;

/**
 * Group of multiple APDU responses.
 *
 * <p>Contains a list of {@link ApduResponseApi} received from the card in response to a {@link
 * CardRequestSpi} and the associated execution status.
 *
 * <p>The execution status includes the state of the logical channel after the operation and the
 * information saying whether a response is present for all APDUs in the {@link CardRequestSpi}.
 *
 * <p>Responses may be missing when this object is embedded in an {@link AbstractApduException}, for
 * example, if the card is removed during processing or if an unsuccessful status word was received
 * and processing was requested to be stopped in this case (see {@link
 * CardRequestSpi#stopOnUnsuccessfulStatusWord()}).
 *
 * @see CardRequestSpi
 * @since 1.0.0
 */
public interface CardResponseApi extends Serializable {

  /**
   * Gets a list of all responses received to the executed APDU requests.
   *
   * @return A non-null list, empty if there is no response.
   * @since 1.0.0
   */
  List<ApduResponseApi> getApduResponses();

  /**
   * Gets the state of the logical channel following the execution of the request.
   *
   * @return True if the logical channel is open.
   * @since 1.0.0
   */
  boolean isLogicalChannelOpen();
}
