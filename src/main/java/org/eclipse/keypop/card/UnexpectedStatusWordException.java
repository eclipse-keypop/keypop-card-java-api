/*
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 */
package org.eclipse.keypop.card;

import org.eclipse.keypop.card.spi.CardRequestSpi;

/**
 * Exception carrying response data received from the card until an unexpected APDU status word is
 * received.
 *
 * @since 1.0.0
 */
public final class UnexpectedStatusWordException extends AbstractApduException {

  /**
   * Builds a new exception embedding card response data.
   *
   * @param cardResponseApi The card responses received so far.
   * @param isCardResponseComplete True if the number responses equals the number of requests
   *     present in the original {@link CardRequestSpi}.
   * @param message Message to identify the exception context.
   * @since 1.0.0
   */
  public UnexpectedStatusWordException(
      CardResponseApi cardResponseApi, boolean isCardResponseComplete, String message) {
    super(cardResponseApi, isCardResponseComplete, message);
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
  public UnexpectedStatusWordException(
      CardResponseApi cardResponseApi,
      boolean isCardResponseComplete,
      String message,
      Throwable cause) {
    super(cardResponseApi, isCardResponseComplete, message, cause);
  }
}
