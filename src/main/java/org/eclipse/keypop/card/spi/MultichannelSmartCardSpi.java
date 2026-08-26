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
package org.eclipse.keypop.card.spi;

/**
 * Multi-channel variant of the smart card SPI, to be implemented by card extensions whose
 * underlying card supports several active logical channels.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#type_MultichannelSmartCardSpi">MultichannelSmartCardSpi</a>
 * for the normative contract.
 *
 * @since 3.0.0
 */
public interface MultichannelSmartCardSpi extends SmartCardSpi {

  /**
   * Returns the logical channel number on which this smart card has been placed.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_MultichannelSmartCardSpi_getChannel">MultichannelSmartCardSpi.getChannel</a>
   * for the normative contract.
   *
   * @return A non-negative value.
   * @since 3.0.0
   */
  int getChannel();
}
