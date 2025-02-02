/*
 * Copyright 2017 Decipher Technology Studios LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.deciphernow.maven.plugins.vault.config;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Vault server.
 */
public class Server implements Serializable {

  private File sslCertificate;

  private boolean sslVerify;

  private String url;

  private String token;

  private List<Path> paths;

  private boolean skipExecution;

  private int kvVersion = 2;

  /**
   * Initializes a new instance of the {@link Server} class.
   */
  public Server() {
  }

  /**
   * Initializes a new instance of the {@link Server} class.
   *
   * @param url the URL of the server
   * @param token the token for the server
   * @param sslVerify {@code true} if the SSL connection should be verified; otherwise, {@code false}
   * @param sslCertificate the SSL certificate file or null
   * @param paths the paths for the server
   */
  public Server(String url, String token, int kvVersion, boolean sslVerify, File sslCertificate, List<Path> paths,
                boolean skipExecution) {
    this.paths = paths;
    this.sslCertificate = sslCertificate;
    this.sslVerify = sslVerify;
    this.token = token;
    this.url = url;
    this.kvVersion = kvVersion;
    this.skipExecution = skipExecution;
  }

  /**
   * Gets the paths for this server.
   *
   * @return the paths
   */
  public List<Path> getPaths() {
    return this.paths;
  }

  /**
   * Gets the SSL certificate file for this server.
   *
   * @return the file
   */
  public File getSslCertificate() {
    return this.sslCertificate;
  }

  /**
   * Gets a value indicating whether SSL connections are verified for this server.
   *
   * @return {@code true} if the SSL connection should be verified; otherwise, {@code false}
   */
  public boolean getSslVerify() {
    return this.sslVerify;
  }

  /**
   * Gets the token used to access this server.
   *
   * @return the token
   */
  public String getToken() {
    return this.token;
  }

  /**
   * Gets the URL of this server.
   *
   * @return the URL
   */
  public String getUrl() {
    return this.url;
  }

  /**
   * Gets the KV version of this secret.
   * @return the version
   */
  public int getKvVersion() {
    return this.kvVersion;
  }

  /**
   * Indicates if server execution should be skipped.
   *
   * @return the skipExecution
   */
  public boolean isSkipExecution() {
    return skipExecution;
  }

  /**
   * Returns a hash code value for this server.
   *
   * @return the hash code
   */
  @Override
public int hashCode() {
    return Objects.hash(this.sslCertificate, this.sslVerify, this.token, this.url, this.kvVersion,
            this.paths, this.skipExecution);
  }

  /**
   * Returns a value indicating whether this server is equal to another object.
   *
   * @return {@code true} if the this server is equal to the object; otherwise, {@code false}
   */
  @Override
public boolean equals(Object object) {
    if (object instanceof Server) {
      Server that = (Server) object;
      return Objects.equals(this.paths, that.paths)
          && Objects.equals(this.sslVerify, that.sslVerify)
          && Objects.equals(this.skipExecution, that.skipExecution)
          && Objects.equals(this.sslCertificate, that.sslCertificate)
          && Objects.equals(this.token, that.token)
          && Objects.equals(this.kvVersion, that.kvVersion)
          && Objects.equals(this.url, that.url);
    }
    return false;
  }

}
