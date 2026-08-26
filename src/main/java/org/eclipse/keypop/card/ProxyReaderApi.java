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
import org.eclipse.keypop.card.spi.MultichannelSmartCardSpi;
import org.eclipse.keypop.card.spi.SmartCardSpi;

/**
 * Reader-side facet exposing the APDU transmission and channel closure operations to card
 * extensions, an adapter of this interface being required to also implement the <b>CardReader</b>
 * interface of the Reader API.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#type_ProxyReaderApi">ProxyReaderApi</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface ProxyReaderApi {

  /**
   * Transmits the provided card request to the smart card identified by the provided SPI, the
   * logical channel remaining open afterwards.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_ProxyReaderApi_transmitCardRequest">ProxyReaderApi.transmitCardRequest</a>
   * for the normative contract.
   *
   * @param cardRequest The card request to transmit.
   * @param smartCard The smart card SPI identifying the target.
   * @return A non-null reference.
   * @throws IllegalArgumentException If one of the provided parameters is null.
   * @throws ReaderBrokenCommunicationException If the communication with the reader has failed.
   * @throws CardBrokenCommunicationException If the communication with the card has failed or if
   *     the smart card is no longer active.
   * @throws UnexpectedStatusWordException If any of the APDUs returned an unexpected status word
   *     and the card request specified the need to check them.
   * @throws ApduExchangeDurationExceededException If a measured APDU exchange duration exceeded the
   *     bound declared on the request.
   * @since 3.0.0
   */
  CardResponseApi transmitCardRequest(CardRequestSpi cardRequest, SmartCardSpi smartCard)
      throws ReaderBrokenCommunicationException,
          CardBrokenCommunicationException,
          UnexpectedStatusWordException,
          ApduExchangeDurationExceededException;

  /**
   * Transmits the provided card request to the smart card identified by the provided SPI and, upon
   * successful completion, closes the corresponding logical channel and deactivates the smart card.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_ProxyReaderApi_transmitCardRequestAndCloseChannel">ProxyReaderApi.transmitCardRequestAndCloseChannel</a>
   * for the normative contract.
   *
   * @param cardRequest The card request to transmit.
   * @param multichannelSmartCard The multi-channel smart card SPI identifying the target.
   * @return A non-null reference.
   * @throws IllegalArgumentException If one of the provided parameters is null.
   * @throws ReaderBrokenCommunicationException If the communication with the reader has failed.
   * @throws CardBrokenCommunicationException If the communication with the card has failed or if
   *     the smart card is no longer active.
   * @throws UnexpectedStatusWordException If any of the APDUs returned an unexpected status word
   *     and the card request specified the need to check them.
   * @throws ApduExchangeDurationExceededException If a measured APDU exchange duration exceeded the
   *     bound declared on the request.
   * @since 3.0.0
   */
  CardResponseApi transmitCardRequestAndCloseChannel(
      CardRequestSpi cardRequest, MultichannelSmartCardSpi multichannelSmartCard)
      throws ReaderBrokenCommunicationException,
          CardBrokenCommunicationException,
          UnexpectedStatusWordException,
          ApduExchangeDurationExceededException;

  /**
   * Closes the logical channel of the smart card identified by the provided SPI and deactivates the
   * smart card, this operation being idempotent.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_ProxyReaderApi_closeChannel">ProxyReaderApi.closeChannel</a>
   * for the normative contract.
   *
   * @param multichannelSmartCard The multi-channel smart card SPI identifying the target.
   * @throws IllegalArgumentException If the provided parameter is null.
   * @throws ReaderBrokenCommunicationException If the communication with the reader has failed.
   * @throws CardBrokenCommunicationException If the communication with the card has failed.
   * @since 3.0.0
   */
  void closeChannel(MultichannelSmartCardSpi multichannelSmartCard)
      throws ReaderBrokenCommunicationException, CardBrokenCommunicationException;
}
