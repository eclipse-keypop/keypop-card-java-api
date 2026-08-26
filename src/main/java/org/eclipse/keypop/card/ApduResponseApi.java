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

import java.io.Serializable;

/**
 * Data received in response to a single APDU command, made serializable so that it can be
 * transported across distributed boundaries.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#type_ApduResponseApi">ApduResponseApi</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface ApduResponseApi extends Serializable {

  /**
   * Returns the raw data received from the card, including the status word.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_ApduResponseApi_getApdu">ApduResponseApi.getApdu</a>
   * for the normative contract.
   *
   * @return An array of at least 2 bytes.
   * @since 1.0.0
   */
  byte[] getApdu();

  /**
   * Returns the data part of the response received from the card, excluding the status word.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_ApduResponseApi_getDataOut">ApduResponseApi.getDataOut</a>
   * for the normative contract.
   *
   * @return A non-null but possibly empty byte array.
   * @since 1.0.0
   */
  byte[] getDataOut();

  /**
   * Returns the status word of the APDU as an int.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_ApduResponseApi_getStatusWord">ApduResponseApi.getStatusWord</a>
   * for the normative contract.
   *
   * @return An integer between 0000h and FFFFh.
   * @since 1.0.0
   */
  int getStatusWord();

  /**
   * Returns the effective duration of the APDU exchange, in milliseconds, as measured by the
   * underlying reader implementation.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_ApduResponseApi_getApduExchangeDuration">ApduResponseApi.getApduExchangeDuration</a>
   * for the normative contract.
   *
   * @return Null if the reader does not provide the measurement.
   * @since 3.0.0
   */
  Long getApduExchangeDuration();
}
