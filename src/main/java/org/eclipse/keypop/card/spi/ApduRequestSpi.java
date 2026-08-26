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
package org.eclipse.keypop.card.spi;

import java.util.Set;

/**
 * Single APDU request, along with its successful status words, its information string and an
 * optional duration bound used to control the APDU exchange execution time.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#type_ApduRequestSpi">ApduRequestSpi</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface ApduRequestSpi {

  /**
   * Returns the APDU bytes to be sent to the card, the <b>Le</b> field being <b>mandatory</b> and
   * set to <b>00h</b> for <b>case 4</b> APDU commands.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_ApduRequestSpi_getApdu">ApduRequestSpi.getApdu</a>
   * for the normative contract.
   *
   * @return An array of at least 4 bytes.
   * @since 1.0.0
   */
  byte[] getApdu();

  /**
   * Returns the status words that must be considered successful for this APDU.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_ApduRequestSpi_getSuccessfulStatusWords">ApduRequestSpi.getSuccessfulStatusWords</a>
   * for the normative contract.
   *
   * @return A non-empty set of integer values containing at least 9000h.
   * @since 1.0.0
   */
  Set<Integer> getSuccessfulStatusWords();

  /**
   * Returns the information about this APDU request (e.g. command name), intended to improve the
   * logging.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_ApduRequestSpi_getInfo">ApduRequestSpi.getInfo</a>
   * for the normative contract.
   *
   * @return Null if no information has been defined.
   * @since 1.0.0
   */
  String getInfo();

  /**
   * Returns the maximum tolerated duration of the APDU exchange, in milliseconds, beyond which the
   * proxy reader must raise an {@code ApduExchangeDurationExceededException}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_ApduRequestSpi_getApduExchangeMaxDuration">ApduRequestSpi.getApduExchangeMaxDuration</a>
   * for the normative contract.
   *
   * @return Null if no bound is defined for this request.
   * @since 3.0.0
   */
  Long getApduExchangeMaxDuration();
}
