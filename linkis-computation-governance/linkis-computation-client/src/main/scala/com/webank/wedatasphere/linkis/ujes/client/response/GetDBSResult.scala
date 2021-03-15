/*
 * Copyright 2019 WeBank
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

package com.webank.wedatasphere.linkis.ujes.client.response

import java.util

import com.webank.wedatasphere.linkis.httpclient.dws.annotation.DWSHttpMessageResult
import com.webank.wedatasphere.linkis.httpclient.dws.response.DWSResult
import com.webank.wedatasphere.linkis.ujes.client.request.UserAction
import org.apache.commons.collections.CollectionUtils

import scala.beans.BeanProperty
import scala.collection.JavaConversions._

@DWSHttpMessageResult("/api/rest_j/v\\d+/datasource/dbs")
class GetDBSResult extends DWSResult with UserAction {
  @BeanProperty var dbs: util.List[util.Map[String, String]] = _

  def getDBSName(): util.List[String] = {
    val dbsList = new util.ArrayList[String]()
    if (CollectionUtils.isNotEmpty(dbs)) {
      dbs.foreach { db =>
        dbsList.add(db.get("dbName"))
      }
    }
    dbsList
  }
}