package com.example.umkmapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.umkmapps.model.DataItem

class UserAdapter(private val users: MutableList<DataItem>) :
    RecyclerView.Adapter<UserAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_users, parent, false)
        return ListViewHolder(
            view
        )
    }

    fun addUser(newUsers: DataItem) {
        users.add(newUsers)
        notifyItemInserted(users.lastIndex)
    }

    fun clear() {
        users.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val users = users[position]

        Glide.with(holder.itemView.context)
            .load(users.avatar)
            .apply(RequestOptions().override(80, 80).placeholder(R.drawable.ic_launcher_foreground))
            .transform(CircleCrop())
            .into(holder.ivAvatar)

        holder.tvUserName.text = "Nama : ${users.firstName}${users.lastName}"
        holder.tvEmail.text = "Email : ${users.email}"
        holder.tvAlamat.text = "Almat : ${users.alamat}"
        holder.tvTotalIuranBulanan.text = "Iuran Bulanan : ${users.totalIuranBulanan}"
        holder.tvTotalIuranIndividu.text = "Iuran Individu : ${users.totalIuranIndividu}"
        holder.tvTotalIuranAkhir.text = "Iuran Akhir : ${users.totalIuranAkhir}"
        holder.tvPengeluaranIuran.text = "Pengeluaran Iuran : ${users.pengeuaranIuran}"
        holder.tvPemanfaatanIuran.text = "Pemanfaatan Iuran : ${users.pemanfaatanIuaran}"
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvUserName: TextView = itemView.findViewById(R.id.itemName)
        var tvEmail: TextView = itemView.findViewById(R.id.itemEmail)
        var ivAvatar: ImageView = itemView.findViewById(R.id.itemAvatar)
        var tvAlamat: TextView = itemView.findViewById(R.id.itemAlamat)
        var tvTotalIuranBulanan: TextView = itemView.findViewById(R.id.itemTotalIuranBulanan)
        var tvTotalIuranIndividu: TextView = itemView.findViewById(R.id.itemTotalIuranIndividu)
        var tvTotalIuranAkhir: TextView = itemView.findViewById(R.id.itemTotalIuranAkhir)
        var tvPengeluaranIuran: TextView = itemView.findViewById(R.id.itemPengeluaranIuran)
        var tvPemanfaatanIuran: TextView = itemView.findViewById(R.id.itemPemanfaatanIuran)
    }
}