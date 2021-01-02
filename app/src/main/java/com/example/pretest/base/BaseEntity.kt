package com.example.pretest.base

import com.chad.library.adapter.base.entity.MultiItemEntity

abstract class BaseEntity : MultiItemEntity {

    protected open var mItemType: Int = 1

    override val itemType: Int
        get() = mItemType
}