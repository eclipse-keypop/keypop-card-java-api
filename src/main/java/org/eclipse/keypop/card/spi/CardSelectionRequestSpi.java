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
 * Data needed to execute a single selection case: the status words qualifying a successful
 * selection and an optional card request to be executed after a successful card selection.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#type_CardSelectionRequestSpi">CardSelectionRequestSpi</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface CardSelectionRequestSpi {

  /**
   * Returns the status words that must be considered successful for this selection case.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_CardSelectionRequestSpi_getSuccessfulSelectionStatusWords">CardSelectionRequestSpi.getSuccessfulSelectionStatusWords</a>
   * for the normative contract.
   *
   * @return A non-empty set of integer values containing at least 9000h.
   * @since 2.0.0
   */
  Set<Integer> getSuccessfulSelectionStatusWords();

  /**
   * Returns the optional follow-up card request to execute after a successful selection.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_CardSelectionRequestSpi_getCardRequest">CardSelectionRequestSpi.getCardRequest</a>
   * for the normative contract.
   *
   * @return Null if no card request has been defined.
   * @since 1.0.0
   */
  CardRequestSpi getCardRequest();
}
