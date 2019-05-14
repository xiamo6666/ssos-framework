/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ssos.flowable.modeler.service;

import com.ssos.flowable.modeler.model.Model;
import com.ssos.flowable.modeler.model.ModelHistory;
import com.ssos.flowable.modeler.repository.ModelHistoryRepository;
import com.ssos.flowable.modeler.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseFlowableModelService {

    protected static final String PROCESS_NOT_FOUND_MESSAGE_KEY = "PROCESS.ERROR.NOT-FOUND";

    @Autowired
    protected ModelRepository modelRepository;

    @Autowired
    protected ModelHistoryRepository modelHistoryRepository;

    protected Model getModel(String modelId, boolean checkRead, boolean checkEdit) {
        Model model = modelRepository.get(modelId);

        if (model == null) {

        }

        return model;
    }

    protected ModelHistory getModelHistory(String modelId, String modelHistoryId, boolean checkRead, boolean checkEdit) {
        // Check if the user has read-rights on the process-model in order to fetch history
        Model model = getModel(modelId, checkRead, checkEdit);
        ModelHistory modelHistory = modelHistoryRepository.get(modelHistoryId);

        // Check if history corresponds to the current model and is not deleted
        if (modelHistory == null || modelHistory.getRemovalDate() != null || !modelHistory.getModelId().equals(model.getId())) {
            throw new RuntimeException("Model history not found: " + modelHistoryId);
        }
        return modelHistory;
    }

}
