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

/**
 * Card extension facet of a successfully selected smart card, an implementation of this SPI being
 * required to also implement the <b>SmartCard</b> interface of the Reader API.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#type_SmartCardSpi">SmartCardSpi</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface SmartCardSpi {

  /**
   * Marks this smart card as no longer active, so that the corresponding <b>SmartCard</b> exposed
   * to the application reports an inactive state. This operation is idempotent.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_SmartCardSpi_deactivate">SmartCardSpi.deactivate</a>
   * for the normative contract.
   *
   * @since 3.0.0
   */
  void deactivate();
}
