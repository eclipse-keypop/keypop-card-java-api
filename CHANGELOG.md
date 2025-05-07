# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
### Fixed
- Fixed JUnit configuration.
### Changed
- Added clarification concerning the construction of "case 4" APDU commands in the `ApduRequestSpi` interface.

## [2.0.1] - 2024-04-12
### Changed
- Java source and target levels `1.6` -> `1.8`
### Upgraded
- Gradle `6.8.3` -> `7.6.4`

## [2.0.0] - 2023-11-27
:warning: The project has been migrated from the [Calypsonet Terminal Card API](https://github.com/calypsonet/calypsonet-terminal-card-java-api)
GitHub repository.
### Changed
- The project license is now "MIT License" (previously "Eclipse Public License 2.0").
- CI: The Gradle plugin `org.eclipse.keyple:keyple-gradle:0.2.+` has been replaced
  by `org.eclipse.keypop:keypop-gradle:0.1.+`.
- Renamed:
  - Artifact `org.calypsonet.terminal:calypsonet-terminal-card-java-api` -> `org.eclipse.keypop:keypop-card-java-api`
  - Package `org.calypsonet.terminal.card` -> `org.eclipse.keypop.card`
  - Interface `CardSelectionSpi` -> `CardSelectionExtensionSpi`
- Moved:
  - Interface `org.calypsonet.terminal.card.spi.ParseException` -> `org.eclipse.keypop.card.ParseException`
  - Method `CardSelectorSpi.getSuccessfulSelectionStatusWords()` -> `CardSelectionRequestSpi.getSuccessfulSelectionStatusWords()`
- The following exceptions classes are now marked as final:
  - `ParseException`
  - `CardBrokenCommunicationException`
  - `ReaderBrokenCommunicationException`
  - `UnexpectedStatusWordException`
### Removed
- Method `CardSelectionRequestSpi.getCardSelector()`
- Interface `CardSelectorSpi` has been moved to the **Keypop Reader Java API**

## [1.0.0] - 2021-10-06
This is the initial release.

[unreleased]: https://github.com/eclipse-keypop/keypop-card-java-api/compare/2.0.1...HEAD
[2.0.1]: https://github.com/eclipse-keypop/keypop-card-java-api/compare/2.0.0...2.0.1
[2.0.0]: https://github.com/eclipse-keypop/keypop-card-java-api/releases/tag/2.0.0
[1.0.0]: https://github.com/calypsonet/calypsonet-terminal-card-java-api/releases/tag/1.0.0