/*
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 */
package org.eclipse.keypop.card;

import org.eclipse.keypop.card.spi.ApduRequestSpi;
import org.eclipse.keypop.card.spi.CardRequestSpi;

/**
 * Reader able to transmit card requests and having control over the physical channel.
 *
 * <p>Backside of the <b>org.eclipse.keypop.reader.CardReader</b> interface present in the <b>Keypop
 * Reader API</b>.
 *
 * <p>An adapter of this interface must also implement <b>CardReader</b>.
 *
 * <p>To use this API, simply cast a <b>CardReader</b> as a <b>ProxyReaderApi</b>.
 *
 * @since 1.0.0
 */
public interface ProxyReaderApi {

  /**
   * Transmits a {@link CardRequestSpi}, applies the provided {@link ChannelControl} policy and
   * returns a {@link CardResponseApi}.
   *
   * <p>The APDUs ({@link ApduRequestSpi}) contained in the {@link CardRequestSpi} are sent to the
   * card, their responses ({@link ApduResponseApi}) are added to a new list ({@link
   * CardResponseApi}).
   *
   * <p><b>Note:</b> in case of an error when sending an APDU (communication error, unexpected
   * status word), an {@link AbstractApduException} exception is thrown. Any responses from
   * previously transmitted APDU commands are attached to this exception.<br>
   * This allows the calling application to be tolerant to card tearing and to retrieve the partial
   * response to the {@link CardRequestSpi} or to have strict control over the APDUs sent to the
   * card (see {@link CardRequestSpi#stopOnUnsuccessfulStatusWord()}).
   *
   * @param cardRequest The card request.
   * @param channelControl The channel control policy to apply.
   * @return A non-null reference.
   * @throws IllegalArgumentException If one of the provided parameters is null.
   * @throws ReaderBrokenCommunicationException If the communication with the reader has failed.
   * @throws CardBrokenCommunicationException If the communication with the card has failed.
   * @throws UnexpectedStatusWordException If any of the APDUs returned an unexpected status word
   *     and the card request specified the need to check them.
   * @since 1.0.0
   */
  CardResponseApi transmitCardRequest(CardRequestSpi cardRequest, ChannelControl channelControl)
      throws ReaderBrokenCommunicationException, CardBrokenCommunicationException,
          UnexpectedStatusWordException;

  /**
   * Releases the communication channel previously established with the card.
   *
   * @throws ReaderBrokenCommunicationException If the communication with the reader has failed.
   * @since 1.0.0
   */
  void releaseChannel() throws ReaderBrokenCommunicationException;
}
