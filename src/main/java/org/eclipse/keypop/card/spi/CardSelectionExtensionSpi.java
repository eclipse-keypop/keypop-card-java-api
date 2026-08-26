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

import org.eclipse.keypop.card.CardSelectionResponseApi;
import org.eclipse.keypop.card.ParseException;

/**
 * Card extension facet driving a selection case: builds the selection request and parses the
 * resulting response into a smart card. An implementation of this SPI is required to also implement
 * the <b>CardSelectionExtension</b> interface of the Reader API.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#type_CardSelectionExtensionSpi">CardSelectionExtensionSpi</a>
 * for the normative contract.
 *
 * @since 2.0.0
 */
public interface CardSelectionExtensionSpi {

  /**
   * Returns the request to use when executing this selection case.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_CardSelectionExtensionSpi_getCardSelectionRequest">CardSelectionExtensionSpi.getCardSelectionRequest</a>
   * for the normative contract.
   *
   * @return A non-null reference.
   * @since 1.0.0
   */
  CardSelectionRequestSpi getCardSelectionRequest();

  /**
   * Parses the response of an executed selection case to produce the corresponding {@link
   * SmartCardSpi}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_CardSelectionExtensionSpi_parse">CardSelectionExtensionSpi.parse</a>
   * for the normative contract.
   *
   * @param cardSelectionResponseApi The card selection response.
   * @return A non-null reference.
   * @throws ParseException If the card selection response parsing failed.
   * @since 1.0.0
   */
  SmartCardSpi parse(CardSelectionResponseApi cardSelectionResponseApi) throws ParseException;
}
