# Implementation Plan - Home Screen and Game Flow

Create a fun and animated "Start Game" screen and ensure a smooth gameplay loop.

## User Review Required

> [!NOTE]
> The "Restart" button in `ResultActivity` will continue to start the game directly, as requested ("deve começar o jogo"). I will also add a way to return to the main menu.

## Proposed Changes

### [Component Name] UI & Layouts

#### [NEW] [activity_start.xml](file:///D:/Programacao/Android/JogoImagem/app/src/main/res/layout/activity_start.xml)
- Create a playful layout with a title ("Quiz das Emoções"), a fun icon/illustration, and a large "INICIAR" button.
- Use the existing `bg_gradient` for visual consistency.

#### [NEW] [pulse.xml](file:///D:/Programacao/Android/JogoImagem/app/src/main/res/anim/pulse.xml)
- Define a scaling animation for the Start button to make it more engaging.

#### [NEW] [float.xml](file:///D:/Programacao/Android/JogoImagem/app/src/main/res/anim/float.xml)
- Define a translation animation for the title or icon to give it a "floating" feel.

#### [MODIFY] [activity_result.xml](file:///D:/Programacao/Android/JogoImagem/app/src/main/res/layout/activity_result.xml)
- Add a "Voltar ao Menu" button to allow users to return to the home screen.

### [Component Name] Activities & Logic

#### [NEW] [StartActivity.java](file:///D:/Programacao/Android/JogoImagem/app/src/main/java/com/example/jogoimagem/StartActivity.java)
- Implement `StartActivity` to handle navigation to `MainActivity`.
- Apply animations to the UI elements on startup.

#### [MODIFY] [ResultActivity.java](file:///D:/Programacao/Android/JogoImagem/app/src/main/java/com/example/jogoimagem/ResultActivity.java)
- Ensure the "Restart" button starts a new `MainActivity`.
- Add logic for the new "Back to Menu" button.

#### [MODIFY] [AndroidManifest.xml](file:///D:/Programacao/Android/JogoImagem/app/src/main/AndroidManifest.xml)
- Change the launcher activity from `MainActivity` to `StartActivity`.
- Declare `StartActivity` and ensure `ResultActivity` and `MainActivity` are properly registered.

## Verification Plan

### Automated Tests
- Build the project using `./gradlew assembleDebug` to ensure no resource or code errors.

### Manual Verification
- **Cold Start**: Verify that `StartActivity` appears first with animations.
- **Navigation**: Click "INICIAR" and verify the quiz starts.
- **Gameplay Loop**: Complete the quiz, reach `ResultActivity`.
- **Restart**: Click "Jogar outra vez" and verify the quiz restarts (score reset, first question).
- **Home Navigation**: Click "Voltar ao Menu" and verify it returns to `StartActivity`.
