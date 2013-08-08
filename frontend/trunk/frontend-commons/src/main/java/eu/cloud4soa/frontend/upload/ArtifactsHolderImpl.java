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

package eu.cloud4soa.frontend.upload;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A session scoped bean aimed to hold the uploaded artifacts to be deployed in the selected PaaS provider.
 *
 * @author Stefano Travelli (Cyntelix)
 * @since 16/10/11 18.48
 */
@Component
@Scope("session")
public class ArtifactsHolderImpl implements ArtifactsHolder, Serializable {

    private List<FileItem> uploadedFiles = new ArrayList<FileItem>();

    @Override
    public void clear() {
        for (FileItem fileItem : uploadedFiles)
            if (fileItem.getFile().exists())
                fileItem.getFile().delete();

        uploadedFiles.clear();
    }

    @Override
    public void addFileItem(String fileName, InputStream stream) throws IOException {

        File tempFile = File.createTempFile("c4s", "tmp");
        FileItem fileItem = new FileItem(tempFile, fileName);

        // Process the input stream
        FileOutputStream out = new FileOutputStream(tempFile);
        int len;
        byte[] buffer = new byte[8192];
        while ((len = stream.read(buffer, 0, buffer.length)) != -1) {
            out.write(buffer, 0, len);
        }

        uploadedFiles.add(fileItem);

    }

    @Override
    public List<FileItem> getUploadedFiles() {
        return uploadedFiles;
    }
}
