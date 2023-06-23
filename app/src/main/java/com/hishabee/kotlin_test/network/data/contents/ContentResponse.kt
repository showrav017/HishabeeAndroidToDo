package com.hishabee.kotlin_test.network.data.contents

import kotlinx.parcelize.Parcelize
import com.hishabee.kotlin_test.network.data.BaseResponse


@Parcelize
data class ContentResponse(
    val `data`: List<List<String>>,
): BaseResponse()