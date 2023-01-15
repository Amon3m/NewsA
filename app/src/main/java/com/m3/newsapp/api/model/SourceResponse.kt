package com.m3.newsapp.api.model

import com.google.gson.annotations.SerializedName

data class SourceResponse(

	@field:SerializedName("sources")
	val sources: List<SourcesItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("code")
	val code: List<SourcesItem?>? = null,
	@field:SerializedName("message")
	val message: List<SourcesItem?>? = null,

)