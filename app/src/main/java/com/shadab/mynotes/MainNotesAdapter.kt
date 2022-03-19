package com.shadab.mynotes

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainNotesAdapter(var data : ArrayList<MainNotes>, var context: Context) : RecyclerView.Adapter<MainNotesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout= LayoutInflater.from(context).inflate(R.layout.main_item,parent,false)

        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = data[position].subj_name
        holder.image.setImageResource(data[position].image)
        holder.itemView.setOnClickListener{
            var download= context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            var pdfUri =  Uri.parse(data[position].url)
            var getPdf = DownloadManager.Request(pdfUri)
            getPdf.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            download.enqueue(getPdf)
            Toast.makeText(context,"Downloading Started", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val name: TextView
        internal val image: ImageView

        init {
            name = itemView.findViewById(R.id.subj_name)
            image = itemView.findViewById(R.id.pdf_image)
        }
    }
}