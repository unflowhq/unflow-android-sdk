# Change Log

## 1.11.0
### Changes
- Lowered the amount of network usage.
- Allowed for more than just `Map<String,String>` for user attributes.

### Added
- Added the question block to get detailed feedback, or ask any question you wish.
- Added an optional privacy mode to disable most events.
- Pause function to temporarily stop Unflow from presenting screens.
 
### Fixed
- Flows will no longer emit repeated values

## 1.10.0

### Changes
- References to `subscriptionId` have been renamed to `spaceKey` to avoid confusion.

### Added
- You can now fetch spaces from the SDK. See `UnflowSdk.spaces()` for more.
- There's a new `Spaces` composable that shows a stack of your spaces.
- Another `Spaces` composable has been added that simply provides you with a list of spaces.
- Tracking an event with a date inside the map will now successfully send the date to the server in miliseconds since 1970.

### Fixed
- Ensured that compose resolves to 1.1.1.
  
## 1.9.3
### Changes
- [Unflow] Reverted the following dependencies to latest stable versions to improve product stability and compatibility.
  - Compose `1.1.1`
  - Ktor `2.0.3`
  - Koin `3.1.6`
  - AndroidX Fragments `1.5.0`
  - CameraX `1.1.0`
### Fixes
- [Unflow] Made internal types related to networking internal again.

## 1.9.1
### Added
- [Unflow] Analytics events for Stories
### Fixes
- [Unflow] Fix implicit permission requests by setting minimumSDKVersion in all modules
- [UnflowUI] Better error handling for videos

## 1.9.0
### Added
- [UnflowUI] Stories
### Fixes
- [Unflow] Non-crashing backwards migrations
- [UnflowUI] Prevent loading of page beyond index of carousel
- [UnflowUI] Fix multiple screens opening on slower devices

## 1.8.0
### Added
- [Unflow] Push notification support
- [Unflow] Include block id in analytics listener events
### Fixed
- [Unflow] Correctly track occurredAt time for events
- [Unflow] Update networking library to prevent crash on older Android versions
- [Unflow] Prevent crashes by providing Proguard rules
- [UnflowUI] Propegate color schemes to all screen elements

## 1.7.1

## 1.7.0
### Added
- [Unflow] Proguard rules
- [Unflow] Ability to reset Unflow by calling initialize again
### Fixed
- [UnflowUI] Close screen after rating block clicked

## 1.6.3
### Added
- [UnflowUI] Gif support
### Fixed
- [UnflowUI] Bottom nav wrong color in dark mode
- [Unflow] Issues integrating on Java

## 1.6.2
### Added
- [Unflow] Improved error handling
- [Unflow] Upgraded dependencies

## 1.6.1
### Fixed
- [UnflowUI] Provide public Opener model for consumption in custom OpenerView

## 1.6.0
### Added
- [Unflow] Reduced minSdkVersion to 21
- [Unflow] getOpeners function
- [Unflow] Reintroduce network logging
- [UnflowUI] Improved analytics listener & events

## 1.5.1
### Added
- [UnflowUI] New screen layouts
- [UnflowUI] Custom openers
- [Unflow] Performance improvements

## 1.4.0
### Added
- [Unflow] Persistent device ID tracking for "anonymous" users
- [UnflowUI] Add native share modal support from buttons

## 1.3.0
### Added
- [Unflow] Optionally show App Store review modal
- [UnflowUI] Video player autoplay toggle
- [UnflowUI] Customizable button radius

## 1.2.0
### Added
- [Unflow] Event tracking
- [Unflow] Automatically triggered screens
- [Unflow] Screen ordering
- [UnflowUI] Emoji / Star rating
- [UnflowUI] Video player
- [UnflowUI] Bottom modal presentation style
### Fixed
- [Unflow] Make openScreen throwing

## 1.1.0
### Added
- [Unflow] Custom fonts
- [UnflowUI] Theming
- [UnflowUI] Long form content

## 1.0.2
### Fixed
- [Unflow UI] Make Jetpack Compose UI an API dependency to fix adding Unflow views in XML layouts

## 1.0.1
### Changed
- [Unflow] Use Android Gradle Plugin version 7.0.3
### Fixed
- [Unflow] Analytics module dependency

## 1.0.0
### Added
- Initial release 🎉
