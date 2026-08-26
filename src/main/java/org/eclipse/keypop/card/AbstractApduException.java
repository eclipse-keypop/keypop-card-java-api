/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keypop.card;

import org.eclipse.keypop.card.spi.CardRequestSpi;

/**
 * Base class of every exception raised by the transmission operations of {@link ProxyReaderApi},
 * carrying the response data received from the card until the failure occurred together with a
 * completeness flag.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#type_AbstractApduException">AbstractApduException</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public abstract class AbstractApduException extends Exception {

  private final CardResponseApi cardResponseApi;
  private final boolean isCardResponseComplete;

  /**
   * Builds a new exception embedding card response data.
   *
   * @param cardResponseApi The card responses received so far.
   * @param isCardResponseComplete True if the number responses equals the number of requests
   *     present in the original {@link CardRequestSpi}.
   * @param message the message to identify the exception context
   * @since 1.0.0
   */
  public AbstractApduException(
      CardResponseApi cardResponseApi, boolean isCardResponseComplete, String message) {
    super(message);
    this.cardResponseApi = cardResponseApi;
    this.isCardResponseComplete = isCardResponseComplete;
  }

  /**
   * Builds a new exception embedding card response data with the originating exception.
   *
   * @param cardResponseApi The card responses received so far.
   * @param isCardResponseComplete True if the number responses equals the number of requests
   *     present in the original {@link CardRequestSpi}.
   * @param message Message to identify the exception context.
   * @param cause The cause
   * @since 1.0.0
   */
  public AbstractApduException(
      CardResponseApi cardResponseApi,
      boolean isCardResponseComplete,
      String message,
      Throwable cause) {
    super(message, cause);
    this.cardResponseApi = cardResponseApi;
    this.isCardResponseComplete = isCardResponseComplete;
  }

  /**
   * Returns the responses collected before the failure occurred.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_AbstractApduException_getCardResponse">AbstractApduException.getCardResponse</a>
   * for the normative contract.
   *
   * @return Null if no response was collected.
   * @since 1.0.0
   */
  public CardResponseApi getCardResponse() {
    return cardResponseApi;
  }

  /**
   * Returns whether all the responses expected from the corresponding {@link CardRequestSpi} have
   * been received.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_AbstractApduException_isCardResponseComplete">AbstractApduException.isCardResponseComplete</a>
   * for the normative contract.
   *
   * @return True if all expected responses have been received.
   * @since 1.0.0
   */
  public boolean isCardResponseComplete() {
    return isCardResponseComplete;
  }
}
