# List and Recycler Views Demo with Jetpack Compose

This project demonstrates the use of Jetpack Compose's `LazyColumn`, click handling, and image loading with Coil to create a dynamic list. The list shows 200 people, each represented with a name and image in a card format. Clicking on a person's card will display a `Toast` with the person's name.

## Features

- **LazyColumn**: Efficiently renders large lists by only rendering items currently visible on the screen.
- **Card Layout**: Displays each person's information inside a card.
- **Click Handling**: Clicking on a card triggers a `Toast` that displays the clicked person's name.
- **Coil Image Loading**: Uses Coil's `rememberImagePainter` to load images from a URL into each card.

## Getting Started

### Prerequisites

To run this project, you will need:

- Android Studio Arctic Fox (or newer)
- Jetpack Compose 1.5.0 (or newer)
- An active internet connection (to load images from URLs)

### Project Structure

- **MainActivity.kt**: The main entry point of the app where the list of `Person` objects is created and the content is set.
- **Person Data Class**: Represents a person with `id`, `section`, `name`, and `imageUrl`.
- **Composable Functions**:
  - `LazyColumnClickableWithImageDemo`: Displays a `LazyColumn` with clickable items.
  - `ListItem`: A composable function that defines the UI for each person in the list.
  - `ImageLoader`: Loads images from a URL using Coil.
  - `ScrollableColumnDemo` and `LazyColumnDemo`: Demonstrations of other `LazyColumn` features (non-clickable and non-image lists).

### Running the App

1. Clone or download the project to your local machine.
2. Open the project in **Android Studio**.
3. Sync the Gradle files to ensure all dependencies are downloaded.
4. Run the project on an emulator or a physical device with an active internet connection.



