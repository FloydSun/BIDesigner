/*
 * Copyright 2015 OSBI Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * The "over write" dialog
 */
var OverwriteModalCN = Modal.extend({
    type: 'info',

    message: '文件已存在，是否覆盖?',

	buttons: [
		{ text: '是', method: 'save' },
		{ text: '否', method: 'close' }
	],

    initialize: function(args) {
        // Initialize properties
        _.extend(this, args);

        this.options.title = '警告';

		this.queryname   = this.name;
		this.queryfolder = this.foldername;
		this.parentobj   = this.parent;
    },

    dummy: function() { return true; },

	save: function(event) {
		event.preventDefault();
		this.parentobj.save_remote(this.queryname, this.queryfolder, this.parentobj);

		$.ajax({
			url: window.location.origin + "/" + "saiku3/rest/report/updateSaiku",
			type: 'get',
			dataType: '',
			data: {
				file: this.foldername + this.queryname + ".saiku",
				name : this.queryname
			},
			success: function(data){
				console.log(data);
			},
			error: function(){

			}
		});

		$(this.el).dialog('destroy').remove();
	}
});
