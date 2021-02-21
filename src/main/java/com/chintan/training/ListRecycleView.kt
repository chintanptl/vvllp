package com.chintan.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListRecycleView : AppCompatActivity() {

    private lateinit var mListRecycleView:RecyclerView
    private lateinit var mLinearLayoutManager: RecyclerView.LayoutManager
    private lateinit var mListAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_recycle_view)

        mListRecycleView = findViewById(R.id.mListRecycleView)
        mLinearLayoutManager = LinearLayoutManager(this)
        val mBookList = arrayListOf<Book>(Book("Book1","Author1","Rs. 400","4.5","C:/Users/chint/AndroidStudioProjects/Training/app/src/main/res/drawable/ic_baseline_favorite"),
            Book("Book1","Author1","Rs. 400","4.5","C:/Users/chint/AndroidStudioProjects/Training/app/src/main/res/drawable/ic_baseline_favorite"),Book("Book1","Author1","Rs. 400","4.5","C:/Users/chint/AndroidStudioProjects/Training/app/src/main/res/drawable/ic_baseline_favorite"),Book("Book1","Author1","Rs. 400","4.5","C:/Users/chint/AndroidStudioProjects/Training/app/src/main/res/drawable/ic_baseline_favorite"),Book("Book1","Author1","Rs. 400","4.5","C:/Users/chint/AndroidStudioProjects/Training/app/src/main/res/drawable/ic_baseline_favorite"),Book("Book1","Author1","Rs. 400","4.5","C:/Users/chint/AndroidStudioProjects/Training/app/src/main/res/drawable/ic_baseline_favorite"),Book("Book1","Author1","Rs. 400","4.5","C:/Users/chint/AndroidStudioProjects/Training/app/src/main/res/drawable/ic_baseline_favorite"),Book("Book1","Author1","Rs. 400","4.5","C:/Users/chint/AndroidStudioProjects/Training/app/src/main/res/drawable/ic_baseline_favorite"))
        mListAdapter = ListAdapter(this,mBookList)

        mListRecycleView.layoutManager = mLinearLayoutManager
        mListRecycleView.adapter = mListAdapter
    }
}