/* **************************************************************************************
 * Copyright (c) 2026 Calypso Networks Association https://calypsonet.org/
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

import org.eclipse.keypop.card.spi.ApduRequestSpi;
import org.eclipse.keypop.card.spi.CardRequestSpi;

/**
 * Indicates that the effective duration of an APDU exchange exceeded the bound declared on the
 * request via {@link ApduRequestSpi#getApduExchangeMaxDuration()}.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#type_ApduExchangeDurationExceededException">ApduExchangeDurationExceededException</a>
 * for the normative contract.
 *
 * @since 3.0.0
 */
public final class ApduExchangeDurationExceededException extends AbstractApduException {

  /**
   * Builds a new exception embedding card response data.
   *
   * @param cardResponseApi The card responses received so far.
   * @param isCardResponseComplete True if the number responses equals the number of requests
   *     present in the original {@link CardRequestSpi}.
   * @param message Message to identify the exception context.
   * @since 3.0.0
   */
  public ApduExchangeDurationExceededException(
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
   * @since 3.0.0
   */
  public ApduExchangeDurationExceededException(
      CardResponseApi cardResponseApi,
      boolean isCardResponseComplete,
      String message,
      Throwable cause) {
    super(cardResponseApi, isCardResponseComplete, message, cause);
  }
}
