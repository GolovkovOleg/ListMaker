package com.example.listmaker

import android.content.Context
import android.preference.PreferenceManager

class ListDataManager(val context: Context) {
    fun saveList(taskList: TaskList) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context).edit()
        sharedPreferences.putStringSet(taskList.name, taskList.tasks.toHashSet())
        sharedPreferences.apply()
    }

    fun readLists(): ArrayList<TaskList> {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val sharedPreferencesContext = sharedPreferences.all
        val taskList = ArrayList<TaskList>()

        for (preferencesItem in sharedPreferencesContext) {
            val itemsHashSet = preferencesItem.value as HashSet<String>
            val list = TaskList(preferencesItem.key, ArrayList(itemsHashSet))
            taskList.add(list)
        }
        return taskList
    }
}