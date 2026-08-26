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

import java.util.List;

/**
 * Ordered list of {@link ApduRequestSpi} to be executed consecutively against the card, along with
 * a flag indicating whether processing stops on an unexpected status word.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#type_CardRequestSpi">CardRequestSpi</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface CardRequestSpi {

  /**
   * Returns the ordered list of APDU requests to be executed.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_CardRequestSpi_getApduRequests">CardRequestSpi.getApduRequests</a>
   * for the normative contract.
   *
   * @return A not empty list.
   * @since 1.0.0
   */
  List<ApduRequestSpi> getApduRequests();

  /**
   * Returns whether the iteration must stop at the first APDU whose response status word is not in
   * its successful status words.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_CardRequestSpi_stopOnUnsuccessfulStatusWord">CardRequestSpi.stopOnUnsuccessfulStatusWord</a>
   * for the normative contract.
   *
   * @return True if the process must stop at the first unsuccessful status word received.
   * @since 1.0.0
   */
  boolean stopOnUnsuccessfulStatusWord();
}
