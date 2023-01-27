package com.aplikasi.apptoko.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aplikasi.apptoko.R
import com.aplikasi.apptoko.response.transaksi.Transaksi
import java.text.NumberFormat
import java.util.*

class LaporanAdapter(val listTransaksi : List<Transaksi>):RecyclerView.Adapter<LaporanAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_laporan, parent, false)
        return LaporanAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transaksi = listTransaksi[position]
        holder.txtTglTransaksi.text = transaksi.tanggal
        holder.txtNoNota.text = "#000"+transaksi.id

        val localeID = Locale("in", "ID")
        val numberFormat = NumberFormat.getCurrencyInstance(localeID)
        holder.txtTotalItemTransaksi.text = numberFormat.format(transaksi.total.toDouble()).toString()
    }

    override fun getItemCount(): Int {
        return listTransaksi.size
    }


    class ViewHolder(itemViem: View) : RecyclerView.ViewHolder(itemViem) {
        val txtTglTransaksi = itemViem.findViewById(R.id.txtTglTransaksi) as TextView
        val txtNoNota = itemViem.findViewById(R.id.txtNoNota) as TextView
        val txtTotalItemTransaksi = itemViem.findViewById(R.id.txtTotalItemTransaksi) as TextView
    }

}