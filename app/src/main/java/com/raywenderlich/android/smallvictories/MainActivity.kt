/*
 *
 * Copyright (c) 2019 Razeware LL
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.smallvictories

import android.content.res.Resources
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

  val viewModel: VictoryViewModel
    get() = ViewModelProviders.of(this).get(VictoryViewModel::class.java)

  val toolbar: Toolbar
    get() = findViewById(R.id.toolbar)

  val fab: FloatingActionButton
    get() = findViewById(R.id.fab)

  val textVictoryCount: TextView
    get() = findViewById(R.id.textVictoryCount)

  val textVictoryTitle: TextView
    get() = findViewById(R.id.textVictoryTitle)

  override fun onCreate(savedInstanceState: Bundle?) {
    // Switch to AppTheme for displaying the activity
    setTheme(R.style.AppTheme)

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setSupportActionBar(toolbar)

    viewModel.viewState.observe(this, Observer { it ->
      it?.let { render(it) }
    })
    viewModel.repository = SharedPreferencesRepository
    viewModel.initialize()

    fab.setOnClickListener {
      viewModel.incrementVictoryCount()
    }
    textVictoryTitle.setOnClickListener { showVictoryTitleDialog(viewModel) }
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.action_reset -> {
        viewModel.reset()
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }

  private fun render(uiModel: VictoryUiModel) {
    when (uiModel) {
      is VictoryUiModel.TitleUpdated -> {
        textVictoryTitle.text = uiModel.title
      }
      is VictoryUiModel.CountUpdated -> {
        textVictoryCount.text = uiModel.count.toString()
      }
    }
  }

  private fun showVictoryTitleDialog(viewModel: VictoryViewModel) {
    AlertDialog.Builder(this).apply {
      setTitle(getString(R.string.dialog_title))

      val input = EditText(this@MainActivity)
      input.setText(textVictoryTitle.text)
      val density = Resources.getSystem().displayMetrics.density
      val padding = Math.round(16 * density)

      val layout = FrameLayout(context)
      layout.setPadding(padding, 0, padding, 0)
      layout.addView(input)

      setView(layout)

      setPositiveButton(getString(R.string.dialog_ok)) { _, _ ->
        viewModel.setVictoryTitle(input.text.toString())
      }
      setNegativeButton(getString(R.string.dialog_cancel), null)
      create().show()
    }
  }
}
