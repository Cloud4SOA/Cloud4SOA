/*
 * This file is part of Cloud4SOA Frontend.
 *
 *     Cloud4SOA Frontend is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Cloud4SOA Frontend is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Cloud4SOA Frontend.  If not, see <http://www.gnu.org/licenses/>.
 */

package eu.cloud4soa.frontend.commons.server.services.soa.mapping;

import eu.cloud4soa.api.datamodel.semantic.other.ProgrammingLanguage;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ProgrammingLanguageModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

/**
 * Mapper for the programming language.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ProgrammingLanguageMapper extends AbstractMapper<ProgrammingLanguage, ProgrammingLanguageModel> {
    @Override
    protected ProgrammingLanguageModel readFrom(ProgrammingLanguage soaInstance) {

        ProgrammingLanguageModel programmingLanguageModel = soaInstance == null ? new ProgrammingLanguageModel() : new ProgrammingLanguageModel(soaInstance.getUriId(), soaInstance.getTermsTitle());

        if (soaInstance != null)
            programmingLanguageModel.set(ProgrammingLanguageModel.VERSION, soaInstance.getVersion());

        String language = Strings.defaultString(programmingLanguageModel.<String>get(ProgrammingLanguageModel.VALUE), programmingLanguageModel.getKey(), Strings.EMPTY);
        String version = Strings.defaultString(programmingLanguageModel.<String>get(ProgrammingLanguageModel.VERSION));

        programmingLanguageModel.setDescription(Strings.join(new String[]{language, version}, Strings.SPACE).trim());


        return programmingLanguageModel;
    }

    @Override
    protected ProgrammingLanguage writeTo(ProgrammingLanguage soaInstance, ProgrammingLanguageModel frontendModel) {

        if (soaInstance == null)
            soaInstance = new ProgrammingLanguage();

        soaInstance.setUriId(frontendModel.getKey());
        soaInstance.setTermsTitle(frontendModel.<String>get(ProgrammingLanguageModel.VALUE));
        soaInstance.setVersion(frontendModel.<String>get(ProgrammingLanguageModel.VERSION));

        return soaInstance;
    }
}
