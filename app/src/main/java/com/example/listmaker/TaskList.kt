package com.example.listmaker

import android.os.Parcel
import android.os.Parcelable

class TaskList(val name: String, val tasks: ArrayList<String> = ArrayList()) : Parcelable {

    constructor(source: Parcel): this (source.readString()!!, source.createStringArrayList()!!)

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeStringList(tasks)
    }

    // not using this method
    override fun describeContents(): Int = 0

    companion object CREATOR: Parcelable.Creator<TaskList> {
        override fun createFromParcel(source: Parcel): TaskList = TaskList(source)
        override fun newArray(size: Int): Array<TaskList?> = arrayOfNulls(size)
    }
}