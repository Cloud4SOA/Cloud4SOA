/*
 *  Copyright 2013 Cloud4SOA, www.cloud4soa.eu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/* Generated by JTB 1.4.4 */
package eu.cloud4soa.cli.profiles.grammar.visitor;

import eu.cloud4soa.cli.profiles.grammar.syntaxtree.*;

public interface IVoidArguVisitor<A> {

  public void visit(final NodeList n, final A argu);

  public void visit(final NodeListOptional n, final A argu);

  public void visit(final NodeOptional n, final A argu);


  public void visit(final NodeSequence n, final A argu);

  public void visit(final NodeToken n, final A argu);

  public void visit(final Scope n, final A argu);

  public void visit(final UserProfile n, final A argu);

  public void visit(final PersonalInfos n, final A argu);

  public void visit(final Birthday n, final A argu);

  public void visit(final AccountInfo n, final A argu);

  public void visit(final Provider n, final A argu);

  public void visit(final ApplicationProfile n, final A argu);

  public void visit(final ApplicationInfos n, final A argu);

  public void visit(final ApplicationCode n, final A argu);

  public void visit(final PaasOfferingProfile n, final A argu);

  public void visit(final PaasOfferingInfos n, final A argu);

  public void visit(final File n, final A argu);

  public void visit(final FileDimension n, final A argu);

  public void visit(final Digest n, final A argu);

  public void visit(final TechnologyInfo n, final A argu);

  public void visit(final ProgrammingLanguage n, final A argu);

  public void visit(final Software n, final A argu);

  public void visit(final SoftwareCategory n, final A argu);

  public void visit(final SoftwareComponent n, final A argu);

  public void visit(final Component n, final A argu);

  public void visit(final Description n, final A argu);

  public void visit(final License n, final A argu);

  public void visit(final Hardware n, final A argu);

  public void visit(final Box n, final A argu);

  public void visit(final BoxComponent n, final A argu);

  public void visit(final HttpRequests n, final A argu);

  public void visit(final Compute n, final A argu);

  public void visit(final ComputationalComponent n, final A argu);

  public void visit(final Architecture n, final A argu);

  public void visit(final Cores n, final A argu);

  public void visit(final Speed n, final A argu);

  public void visit(final Memory n, final A argu);

  public void visit(final Cache n, final A argu);

  public void visit(final NetworkResource n, final A argu);

  public void visit(final CommunicationalComponent n, final A argu);

  public void visit(final Bandwidth n, final A argu);

  public void visit(final Latency n, final A argu);

  public void visit(final StorageResource n, final A argu);

  public void visit(final StorageComponent n, final A argu);

  public void visit(final Capacity n, final A argu);

  public void visit(final Channels n, final A argu);

  public void visit(final Api n, final A argu);

  public void visit(final Cli n, final A argu);

  public void visit(final WebInterface n, final A argu);

  public void visit(final Operation n, final A argu);

  public void visit(final Command n, final A argu);

  public void visit(final InformationReturned n, final A argu);

  public void visit(final Version n, final A argu);

}
