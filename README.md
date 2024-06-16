
# BeautifulFlower

This is my experimental app which i have made during my initial stage of learning an Android development.When you launch the app first you see is 4 different flower options.

Once you click on any one of them the new screen will appear based on your preference. Then you can read the details about that flower.

Below are the tools, frameworks, Languages used to create this app:

Android Studio, Jetpack compose, Github, Kotlin

Jetpack Compose concepts used in this code:

    Composable functions:

    The core building blocks of Jetpack Compose UI. They are annotated with @Composable and define the UI elements and their behavior. (e.g., FlowerApp, AsterDetails, etc.)
    State management: The rememberSaveable function is used to store state (shouldShowOnboarding) that needs to survive configuration changes.
    Surface: The foundation for building UIs. It provides a background and can contain other UI elements.
    Column & Row: Layout elements used to arrange child elements vertically or horizontally.
    Modifier: A way to apply styles and configurations to composables. (e.g., .padding, .clip, etc.)
    Image: Used to display images from resources.
    Text: Used to display text with various styles.
    LazyColumn: For displaying a large list of items efficiently.
    IconButton: A clickable button with an icon.
    Icon: Represents an icon from the Material Icons library.
    ContentScale: Defines how an image is scaled within its bounds. (e.g., .Crop)
    shapes: Custom shapes defined in the theme.
    Navigation: Although not explicitly implemented here, the onBackClicked functions in detail screens hint at potential navigation behavior.

Kotlin concepts used in this code:

    Functions: Define reusable blocks of code with parameters and a return value. (e.g., FlowerApp, etc.)
    Variables: Used to store data (shouldShowOnboarding, text, etc.)
    val and var: val for read-only variables, var for mutable variables.
    Lists: Collections of items (Aster, Bloom, etc.)
    if statements: Control flow based on conditions.
    when expression: Conditional branching for multiple options.
    for loops: Iterate over a collection of items.
    Resource access: Accessing resources using R.drawable.id.
    Class: Defines a blueprint for creating objects. (e.g., MainActivity)
    Modifiers (companion object): Used to define static members of a class. (e.g., private lists)

This code demonstrates a solid foundation in both Jetpack Compose and Kotlin concepts. It effectively combines UI building, state management, and data handling to create an interactive flower app.
![Untitled design](https://github.com/Nayanpatel48/BeautifulFlowers/assets/149961476/66bf7bf9-3843-4a2e-ac20-bf19ed19262e)