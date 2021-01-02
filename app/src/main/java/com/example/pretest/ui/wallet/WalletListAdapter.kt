package com.example.pretest.ui.wallet

import android.annotation.SuppressLint
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.pretest.R
import com.example.pretest.base.BaseMultiItemQuickAdapter
import com.example.pretest.data.entity.ItemEntity
import com.example.pretest.databinding.ViewItemAdBinding
import com.example.pretest.databinding.ViewItemCardViewCoinBinding
import com.example.pretest.loadUrl

class WalletListAdapter : BaseMultiItemQuickAdapter<ItemEntity>() {

    init {
        addItemType(ItemEntity.ITEM_1, R.layout.view_item_card_view_coin)
        addItemType(ItemEntity.ITEM_2, R.layout.view_item_ad)
    }

    @SuppressLint("SetTextI18n")
    override fun convert(holder: BaseViewHolder, item: ItemEntity) {
        when (holder.itemViewType) {
            ItemEntity.ITEM_1 -> {
                with(ViewItemCardViewCoinBinding.bind(holder.itemView)) {
                    icon.loadUrl("https://event.12cm.com.tw/starbucks/img/siren-l.png")
                    coinName.text = "容幣_${holder.layoutPosition}"
                }
            }

            ItemEntity.ITEM_2 -> {
                with(ViewItemAdBinding.bind(holder.itemView)) {
                    icon.loadUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAax1eyYpVGoaVSQdz-PJ3kB4I6uzNoPNaLQ&usqp=CAU")
                }
            }
        }
    }
}