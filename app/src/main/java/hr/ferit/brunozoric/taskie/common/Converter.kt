package hr.ferit.brunozoric.taskie.common

import androidx.room.TypeConverter
import hr.ferit.brunozoric.taskie.R
import hr.ferit.brunozoric.taskie.model.Priority

class Converter {
    companion object{
        @TypeConverter
        @JvmStatic
        fun fromPriority(value: Priority): Int{
        return value.getColor()
    }

        @TypeConverter
        @JvmStatic
        fun toPriority(value: Int): Priority{
            if(R.color.colorLow == value) return Priority.LOW
            else if(R.color.colorMedium == value) return Priority.MEDIUM
            else if(R.color.colorHigh == value) return Priority.HIGH
            else return Priority.LOW
        }
    }
}