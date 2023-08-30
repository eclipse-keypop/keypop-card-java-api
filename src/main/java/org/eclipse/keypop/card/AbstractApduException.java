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

import org.eclipse.keypop.card.spi.CardRequestSpi;

/**
 * Generic exception carrying response data received from the card until a communication failure
 * occurs or an unexpected APDU status word is received.
 *
 * @since 1.0.0
 */
public class AbstractApduException extends Exception {

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
   * Gets the response data received so far.
   *
   * @return A non-null reference.
   * @since 1.0.0
   */
  public CardResponseApi getCardResponse() {
    return cardResponseApi;
  }

  /**
   * Indicates if all the responses expected from the corresponding {@link CardRequestSpi} have been
   * received.
   *
   * @return True if all expected responses have been received.
   * @since 1.0.0
   */
  boolean isCardResponseComplete() {
    return isCardResponseComplete;
  }
}
