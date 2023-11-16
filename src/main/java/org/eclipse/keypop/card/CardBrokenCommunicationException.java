/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.card;

import org.eclipse.keypop.card.spi.CardRequestSpi;

/**
 * Exception carrying response data received from the card until a communication failure with the
 * card occurs.
 *
 * @since 1.0.0
 */
public final class CardBrokenCommunicationException extends AbstractApduException {

  /**
   * Builds a new exception embedding card response data.
   *
   * @param cardResponseApi The card responses received so far.
   * @param isCardResponseComplete True if the number responses equals the number of requests
   *     present in the original {@link CardRequestSpi}.
   * @param message Message to identify the exception context.
   * @since 1.0.0
   */
  public CardBrokenCommunicationException(
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
  public CardBrokenCommunicationException(
      CardResponseApi cardResponseApi,
      boolean isCardResponseComplete,
      String message,
      Throwable cause) {
    super(cardResponseApi, isCardResponseComplete, message, cause);
  }
}
