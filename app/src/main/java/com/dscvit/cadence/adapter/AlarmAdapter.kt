package com.dscvit.cadence.adapter

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.dscvit.cadence.R
import com.dscvit.cadence.model.alarm.Alarm
import com.dscvit.cadence.util.AlarmListener
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.switchmaterial.SwitchMaterial
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AlarmAdapter(
    private var alarms: List<Alarm>,
    private val switchListener: AlarmListener
) :
    RecyclerView.Adapter<AlarmAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val alarmName: TextView = view.findViewById(R.id.alarmName)
        val alarmTime: TextView = view.findViewById(R.id.alarmTime)
        val alarmDays: TextView = view.findViewById(R.id.alarmDays)
        val alarmSwitch: SwitchMaterial = view.findViewById(R.id.alarmSwitch)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_alarm, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val alarm = alarms[position]

        viewHolder.apply {
            alarmName.text = alarm.alarmName
            alarmSwitch.isChecked = alarm.isOn
            val is24hr = DateFormat.is24HourFormat(itemView.context)
            val t = "${alarm.hour}:${alarm.minute}"
            val formatTime =
                SimpleDateFormat(if (is24hr) "HH:mm" else "h:mm a", Locale.getDefault())
            val simpleDateFormat = SimpleDateFormat("hh:mm", Locale.getDefault())
            val timeDate: Date = simpleDateFormat.parse(t)!!
            alarmTime.text = formatTime.format(timeDate)

            var days = ""
            if (alarm.monday) days += "Mon, "
            if (alarm.tuesday) days += "Tue, "
            if (alarm.wednesday) days += "Wed, "
            if (alarm.thursday) days += "Thu, "
            if (alarm.friday) days += "Fri, "
            if (alarm.saturday) days += "Sat, "
            if (alarm.sunday) days += "Sun, "
            if (days != "") days = days.substring(0, days.length - 2)
            if (days == "") days = "No Repeat"
            alarmDays.text = days

            alarmSwitch.setOnCheckedChangeListener { _, isChecked ->
                alarm.isOn = isChecked
                switchListener.onToggle(alarm)
            }

            itemView.setOnClickListener {
                switchListener.onEdit(alarm)
            }

            itemView.setOnLongClickListener {
                val v: View = LayoutInflater
                    .from(itemView.context)
                    .inflate(R.layout.dialog_alarm_options, null)

                val dialog = MaterialAlertDialogBuilder(itemView.context)
                    .setView(v)
                    .setBackground(
                        AppCompatResources.getDrawable(
                            itemView.context,
                            R.color.transparent
                        )
                    )
                    .create()

                val editBtn = v.findViewById<Button>(R.id.edit_btn)
                val deleteBtn = v.findViewById<Button>(R.id.delete_btn)
                val cancelBtn = v.findViewById<Button>(R.id.cancel_btn)

                editBtn.setOnClickListener {
                    switchListener.onEdit(alarm)
                    dialog.dismiss()
                }

                deleteBtn.setOnClickListener {
                    switchListener.onDelete(alarm)
                    dialog.dismiss()
                }

                cancelBtn.setOnClickListener {
                    dialog.dismiss()
                }
                dialog.show()

                true
            }
        }
    }

    fun dataSetChange(newAlarms: List<Alarm>) {
        alarms = newAlarms
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = alarms.size
}
