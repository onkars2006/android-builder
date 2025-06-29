I can't create a full Android app for you here.  Generating a complete, compiled Android app requires a development environment (Android Studio), SDKs, and the ability to build and deploy APKs, which is beyond the capabilities of this text-based interface.

However, I can provide you with a solid Kotlin code foundation and design guidance to build a beautiful and simple Todo app yourself.  You'll need to adapt and expand upon this to create the full application.

**1. Project Setup (Android Studio):**

* Create a new project in Android Studio, selecting "Empty Activity" as the template.
* Choose Kotlin as the language.
* Choose a suitable name and package for your app (e.g., `com.example.beautifultodo`).


**2. UI Design (XML Layout - `activity_main.xml`):**

This uses Material Design for a modern look.  You can customize the colors and styles further.

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/background_color"  <!-- Define this color in colors.xml -->
    tools:context=".MainActivity">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/todoRecyclerView"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/addTodoButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="16dp"
        android:layout_marginBottom="16dp"
        android:src="@drawable/ic_add"  <!-- Replace with your add icon -->
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

**3.  Data Class (Kotlin):**

```kotlin
data class TodoItem(val id: Int, val task: String, var isCompleted: Boolean = false)
```

**4. RecyclerView Adapter (Kotlin):**

```kotlin
class TodoAdapter(private val todoList: MutableList<TodoItem>, private val onItemClickListener: (TodoItem) -> Unit) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    // ... (ViewHolder, onBindViewHolder, onCreateViewHolder - standard RecyclerView implementation)
    // Implement item click listener within onBindViewHolder to handle checkboxes etc.

    override fun getItemCount(): Int = todoList.size

    fun updateList(newList: List<TodoItem>) {
        todoList.clear()
        todoList.addAll(newList)
        notifyDataSetChanged()
    }

    // ... (ViewHolder class)
}
```

**5.  MainActivity (Kotlin):**

```kotlin
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter
    private var todoList = mutableListOf<TodoItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView and adapter
        binding.todoRecyclerView.setHasFixedSize(true)
        todoAdapter = TodoAdapter(todoList) { todoItem ->
            // Handle item click (e.g., update isCompleted status)
        }
        binding.todoRecyclerView.adapter = todoAdapter

        // Add a new todo item (example)
        binding.addTodoButton.setOnClickListener {
            // Show a dialog to get new task input, then add it to the list and update the adapter
            // ... (Implement dialog code)
        }
        //Load data from local storage

    }
}
```

**6.  Styling (styles.xml, colors.xml, themes.xml):**

Define your app's colors, fonts, and styles in these XML files to achieve a beautiful look. Use Material Design color palettes for consistency.  Consider using custom fonts for a more unique feel.


**7. Data Persistence:**

Use Room Persistence Library or SharedPreferences to save and load your todo list data persistently.


**Remember:**  This is a skeletal structure. You need to implement:

* **Dialog for adding new Todo items:** Use an AlertDialog or a custom dialog.
* **Checkbox in the RecyclerView:** Allow users to mark tasks as complete.
* **Data Persistence:** Save and load the `todoList` to avoid data loss on app close.
* **Error Handling:**  Handle potential exceptions gracefully.
* **Animations:** Consider adding subtle animations for a polished user experience.
* **More Advanced Features (Optional):**  Prioritization, due dates, categories, etc.

This expanded outline and code will help you build a beautiful Todo app in Android Studio. Remember to consult the official Android documentation and tutorials for detailed information on each component and library used.
