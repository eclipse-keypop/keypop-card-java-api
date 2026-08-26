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
import org.eclipse.keypop.card.spi.CardSelectionRequestSpi;

/**
 * Data observed during the start-up phase with the card: the selection step itself, the channel on
 * which the card has been placed and any additional commands executed afterwards.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#type_CardSelectionResponseApi">CardSelectionResponseApi</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface CardSelectionResponseApi {

  /**
   * Returns the logical channel number on which the card has been placed by the selection, 0 for a
   * single-channel selection scenario.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_CardSelectionResponseApi_getChannel">CardSelectionResponseApi.getChannel</a>
   * for the normative contract.
   *
   * @return A non-negative value.
   * @since 3.0.0
   */
  int getChannel();

  /**
   * Returns the card's power-on data, i.e. the data retrieved by the reader when the card is
   * inserted, as a string that may be either a hexadecimal string or any other relevant
   * representation.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_CardSelectionResponseApi_getPowerOnData">CardSelectionResponseApi.getPowerOnData</a>
   * for the normative contract.
   *
   * @return Null if no power-on data is available.
   * @since 1.0.0
   */
  String getPowerOnData();

  /**
   * Returns the {@link ApduResponseApi} received from the card in response to the <b>Select
   * Application</b> command.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_CardSelectionResponseApi_getSelectApplicationResponse">CardSelectionResponseApi.getSelectApplicationResponse</a>
   * for the normative contract.
   *
   * @return Null if no Select Application command was performed.
   * @since 1.0.0
   */
  ApduResponseApi getSelectApplicationResponse();

  /**
   * Returns whether the inserted card matches the selection filters.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_CardSelectionResponseApi_hasMatched">CardSelectionResponseApi.hasMatched</a>
   * for the normative contract.
   *
   * @return True if the card inserted matches the selection filters.
   * @since 1.0.0
   */
  boolean hasMatched();

  /**
   * Returns the responses of the card to the requests present in the {@link CardRequestSpi} of the
   * {@link CardSelectionRequestSpi}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_CardSelectionResponseApi_getCardResponse">CardSelectionResponseApi.getCardResponse</a>
   * for the normative contract.
   *
   * @return Null if no additional command was executed.
   * @since 1.0.0
   */
  CardResponseApi getCardResponse();
}
